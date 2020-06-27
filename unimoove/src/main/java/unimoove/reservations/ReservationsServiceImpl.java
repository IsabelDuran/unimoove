package unimoove.reservations;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import unimoove.api.reservations.ReservationCreationRequest;
import unimoove.api.reservations.ReservationPaginatedResponse;
import unimoove.api.reservations.ReservationResponse;
import unimoove.api.reservations.ReservationStateChangeRequest;
import unimoove.api.utils.PaginationInfo;
import unimoove.trips.Trip;
import unimoove.trips.TripsRepository;
import unimoove.users.User;
import unimoove.users.UsersRepository;
import unimoove.utils.SecurityUtils;

@Service
public class ReservationsServiceImpl implements ReservationsService {

	private static final int STATUS_PENDING = 0;
	private static final int STATUS_FULL = 1;
	private static final int STATUS_CANCELLED = 3;

	private ReservationsRepository reservationsRepository;

	private UsersRepository usersRepository;

	private TripsRepository tripsRepository;

	private ReservationMapper reservationMapper;

	@Autowired
	public ReservationsServiceImpl(ReservationsRepository reservationsRepository, UsersRepository usersRepository,
			TripsRepository tripsRepository, ReservationMapper reservationMapper) {
		super();
		this.reservationsRepository = reservationsRepository;
		this.usersRepository = usersRepository;
		this.tripsRepository = tripsRepository;
		this.reservationMapper = reservationMapper;
	}

	@Override
	@Transactional
	public void addReservation(ReservationCreationRequest reservationCreationRequest) throws FullTripException {
		Trip trip = tripsRepository.findById(reservationCreationRequest.getIdTrip()).orElse(null);
		if (trip.getState() == 0) {
			User user = getUser();
			Reservation reservation = new Reservation(OffsetDateTime.now(), STATUS_PENDING, trip);
			reservation.setUser(user);
			user.getReservations().add(reservation);
			trip.getReservations().add(reservation);
			trip.decreaseAvailableSeats();
			if(trip.getNumberAvailableSeats() == 0) {
				trip.setState(STATUS_FULL);
			}

			reservationsRepository.save(reservation);
			tripsRepository.save(trip);
			usersRepository.save(user);
		} else {
			throw new FullTripException("The trip is already full");
		}

	}

	@Override
	@Transactional
	public void deleteReservation(String idReservation) {
		Reservation reservation = reservationsRepository.findById(Long.parseLong(idReservation)).get();
		Trip trip = tripsRepository.findById(reservation.getTrip().getId()).orElse(null);
		User user = getUser();

		user.getReservations().remove(reservation);
		trip.getReservations().remove(reservation);

		reservationsRepository.delete(reservation);
		tripsRepository.save(trip);
		usersRepository.save(user);
	}

	@Override
	@Transactional
	public ReservationPaginatedResponse getTripReservations(String idTrip, Integer page, Integer size) {
		Page<Reservation> matchedReservations = reservationsRepository
				.searchReservationsByIdTrip(Long.parseLong(idTrip), PageRequest.of(page, size));
		List<ReservationResponse> reservationResponses = matchedReservations
				.map(reservation -> reservationMapper.reservationToReservationResponse(reservation)).stream()
				.collect(Collectors.toList());

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalElements(matchedReservations.getNumberOfElements());
		paginationInfo.setTotalPages(matchedReservations.getTotalPages());

		ReservationPaginatedResponse reservationPaginatedResponse = new ReservationPaginatedResponse();
		reservationPaginatedResponse.setPages(reservationResponses);
		reservationPaginatedResponse.setPaginationInfo(paginationInfo);

		return reservationPaginatedResponse;

	}

	@Override
	@Transactional
	public ReservationPaginatedResponse getUserReservations(String username, Integer page, Integer size) {
		Page<Reservation> matchedReservations = reservationsRepository.searchUserReservations(
				usersRepository.findUserByUsername(username).getId(), PageRequest.of(page, size));
		List<ReservationResponse> reservationResponses = matchedReservations
				.map(reservation -> reservationMapper.reservationToReservationResponse(reservation)).stream()
				.collect(Collectors.toList());

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalElements(matchedReservations.getNumberOfElements());
		paginationInfo.setTotalPages(matchedReservations.getTotalPages());

		ReservationPaginatedResponse reservationPaginatedResponse = new ReservationPaginatedResponse();
		reservationPaginatedResponse.setPages(reservationResponses);
		reservationPaginatedResponse.setPaginationInfo(paginationInfo);

		return reservationPaginatedResponse;
	}
	
	@Override
	@Transactional
	public void modifyReservationState(ReservationStateChangeRequest reservationStateChangeRequest,
			String idReservation) {
		Reservation reservation = reservationsRepository.findById(Long.parseLong(idReservation)).get();
		reservation.setStatus(STATUS_CANCELLED);
		
		reservationsRepository.save(reservation);
		
	}

	private User getUser() {
		User user = usersRepository.findUserByUsername(SecurityUtils.currentUserUsername());
		if (user == null)
			throw new EntityNotFoundException("Usuario no encontrado");
		return user;
	}



}

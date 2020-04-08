package unimoove.reservations;

import java.time.OffsetDateTime;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimoove.api.reservations.ReservationCreationRequest;
import unimoove.trips.Trip;
import unimoove.trips.TripsRepository;
import unimoove.users.User;
import unimoove.users.UsersRepository;
import unimoove.utils.SecurityUtils;

@Service
public class ReservationsServiceImpl implements ReservationsService {

	private static final int STATUS_PENDING = 0;

	private ReservationsRepository reservationsRepository;

	private UsersRepository usersRepository;

	private TripsRepository tripsRepository;

	@Autowired
	public ReservationsServiceImpl(ReservationsRepository reservationsRepository, UsersRepository usersRepository,
			TripsRepository tripsRepository) {
		super();
		this.reservationsRepository = reservationsRepository;
		this.usersRepository = usersRepository;
		this.tripsRepository = tripsRepository;
	}

	@Override
	@Transactional
	public void addReservation(ReservationCreationRequest reservationCreationRequest) {
		Trip trip = tripsRepository.findById(reservationCreationRequest.getIdTrip()).orElse(null);
		User user = getUser();
		Reservation reservation = new Reservation(OffsetDateTime.now(), STATUS_PENDING, trip);
		reservation.setUser(user);
		user.getReservations().add(reservation);
		trip.getReservations().add(reservation);

		reservationsRepository.save(reservation);
		tripsRepository.save(trip);
		usersRepository.save(user);

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

	private User getUser() {
		User user = usersRepository.findUserByUsername(SecurityUtils.currentUserUsername());
		if (user == null)
			throw new EntityNotFoundException("Usuario no encontrado");
		return user;
	}


}

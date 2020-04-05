package unimoove.places;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import unimoove.api.places.PlaceCategoryChangeRequest;
import unimoove.api.places.PlaceCreationRequest;
import unimoove.api.places.PlaceIdChangeRequest;
import unimoove.api.places.PlaceNameChangeRequest;
import unimoove.api.places.PlacePaginatedResponse;
import unimoove.api.places.PlaceResponse;
import unimoove.api.trips.TripPaginatedResponse;
import unimoove.api.utils.PaginationInfo;

@Service
public class PlacesServiceImpl implements PlacesService {
	private PlacesRepository placesRepository;
	private PlaceMapper placeMapper;

	@Autowired
	public PlacesServiceImpl(PlacesRepository placesRepository, PlaceMapper placeMapper) {
		this.placesRepository = placesRepository;
		this.placeMapper = placeMapper;
	}

	@Override
	@Transactional
	public void addPlace(PlaceCreationRequest placeCreationRequest) throws ConstraintViolationException {
		Place place = placeMapper.placeCreationRequestToPlace(placeCreationRequest);
		try {
			placesRepository.save(place);
		} catch (ConstraintViolationException exception) {
			throw new ConstraintViolationException("The place already exists", null, null);
		}

	}

	@Override
	@Transactional
	public void deletePlace(String placeId) {
		Place place = findPlace(placeId);
		placesRepository.delete(place);
		
	}

	@Override
	@Transactional
	public void modifyPlaceId(PlaceIdChangeRequest placeIdChangeRequest, String placeId) {
		Place place = findPlace(placeId);
		place.setIdPlace(placeIdChangeRequest.getNewPlaceId());
		placesRepository.save(place);
		
	}

	@Override
	@Transactional
	public void modifyPlaceName(PlaceNameChangeRequest placeNameChangeRequest, String placeId) {
		Place place = findPlace(placeId);
		place.setName(placeNameChangeRequest.getNewName());
		placesRepository.save(place);
		
	}

	@Override
	@Transactional
	public void modifyPlaceCategory(PlaceCategoryChangeRequest placeCategoryChangeRequest, String placeId) {
		Place place = findPlace(placeId);
		place.setCategory(placeCategoryChangeRequest.getNewCategory());
		placesRepository.save(place);
		
	}
	
	@Override
	@Transactional
	public PlaceResponse getPlace(String placeId) {
		PlaceResponse placeResponse = placeMapper.placeToPlaceResponse(findPlace(placeId));
		return placeResponse;
	}
	
	private Place findPlace(String placeId) {
		Place place = placesRepository.findByPlaceId(placeId);
		if(place == null)
			throw new EntityNotFoundException("No se ha encontrado el lugar " + placeId);
		return place;
	}

	@Override
	public PlacePaginatedResponse searchPlaces(String name, Integer page, Integer size) {
		Page<Place> matchedPlaces = placesRepository.searchTrips(name, PageRequest.of(page, size));
		List<PlaceResponse> placeResponses = matchedPlaces.map(place -> placeMapper.placeToPlaceResponse(place)).stream()
				.collect(Collectors.toList());
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setTotalElements(matchedPlaces.getNumberOfElements());
		paginationInfo.setTotalPages(matchedPlaces.getTotalPages());

		PlacePaginatedResponse paginatedResponse = new PlacePaginatedResponse();
		paginatedResponse.setPages(placeResponses);
		paginatedResponse.setPaginationInfo(paginationInfo);

		return paginatedResponse;
	}

}

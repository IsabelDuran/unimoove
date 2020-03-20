package unimoove.places;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimoove.api.places.PlaceCategoryChangeRequest;
import unimoove.api.places.PlaceCreationRequest;
import unimoove.api.places.PlaceIdChangeRequest;
import unimoove.api.places.PlaceNameChangeRequest;
import unimoove.api.places.PlaceResponse;

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

}

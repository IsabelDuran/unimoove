package unimoove.cars;

import java.util.Set;

import org.mapstruct.Mapper;

import unimoove.api.users.CarCreationRequest;
import unimoove.api.users.CarResponse;

@Mapper(componentModel = "spring")
public interface CarMapper {
	Car carCreationRequestToCar(CarCreationRequest carCreationRequest);
	Set<CarResponse> carsToCarsResponse(Set<Car> cars);
}

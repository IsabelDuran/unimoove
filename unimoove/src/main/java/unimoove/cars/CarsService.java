package unimoove.cars;

import java.util.Set;

import org.springframework.stereotype.Service;

import unimoove.api.users.CarBrandChangeRequest;
import unimoove.api.users.CarCreationRequest;
import unimoove.api.users.CarModelChangeRequest;
import unimoove.api.users.CarResponse;

@Service
public interface CarsService {
	public void addCar(CarCreationRequest carCreationRequest, String username);
	public Set<CarResponse> getCarsFromUser(String username);
	public void deleteCar(String plate, String username);
	public void modifyCarBrand(CarBrandChangeRequest carBrandChangeRequest, String plate);
	public void modifyCarModel(CarModelChangeRequest carModelChangeRequest, String plate);
}

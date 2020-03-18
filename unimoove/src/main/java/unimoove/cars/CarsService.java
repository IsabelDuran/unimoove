package unimoove.cars;

import java.util.Set;

import org.springframework.stereotype.Service;

import unimoove.api.users.CarCreationRequest;
import unimoove.api.users.CarResponse;

@Service
public interface CarsService {
	public void addCar(CarCreationRequest carCreationRequest, String username);
	public Set<CarResponse> getCarsFromUser(String username);
}

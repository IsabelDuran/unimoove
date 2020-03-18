package unimoove.cars;

import java.util.Set;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unimoove.api.users.CarCreationRequest;
import unimoove.api.users.CarResponse;
import unimoove.users.User;
import unimoove.users.UsersRepository;

@Service
public class CarsServiceImpl implements CarsService {

	private CarsRepository carsRepository;
	private UsersRepository userRepository;
	private CarMapper carMapper;

	@Autowired
	public CarsServiceImpl(CarsRepository carsRepository, UsersRepository userRepository, CarMapper carMapper) {
		super();
		this.carsRepository = carsRepository;
		this.userRepository = userRepository;
		this.carMapper = carMapper;
	}

	@Override
	@Transactional
	public void addCar(CarCreationRequest carCreationRequest, String username) {
		Car newCar = carMapper.carCreationRequestToCar(carCreationRequest);
		User user = userRepository.findUserByUsername(username);
		if(user == null)
			throw new EntityNotFoundException("Usuario no encontrado");

		user.getCars().add(carsRepository.save(newCar));
		userRepository.save(user);

	}

	@Override
	@Transactional
	public Set<CarResponse> getCarsFromUser(String username) {
		User user = userRepository.findUserByUsernameWithCars(username);
		if(user == null)
			throw new EntityNotFoundException("Usuario no encontrado");
		Set<Car> cars = user.getCars();
		
		return carMapper.carsToCarsResponse(cars);
		
	}
}

package com.lti.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.VehicleInfo;
import com.lti.entity.VehicleDetails;
import com.lti.service.VehicleDetailsServiceInterface;

/**
 * this is a VehicleDetailController that will be interacting with front-end(Angular)
 * 
 * @author Chetan
 */

@CrossOrigin
@RestController
public class VehicleDetailController {

	@Autowired
	private VehicleDetailsServiceInterface vehicleDetServe;	
	
	@PostMapping("/addVehicle")
	public VehicleInfo addVehicle(@RequestBody VehicleDetails v ) {
		
		VehicleDetails v1 = vehicleDetServe.addNewVehicle(v);
		    VehicleInfo vh = new VehicleInfo();
			vh.setStatus(true);
			vh.setMessage("Vehicle added Successfully");
			vh.setManufacturer(v1.getManufacturer());
			vh.setModel(v1.getModel());
			vh.setPrice(v1.getPrice());
			vh.setVid(v1.getId());
			return vh;
		}
		
	}
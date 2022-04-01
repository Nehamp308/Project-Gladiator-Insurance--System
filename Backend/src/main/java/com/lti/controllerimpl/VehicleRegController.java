package com.lti.controllerimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.dto.VehicleRegInfo;
import com.lti.entity.VehicleRegisteredInfo;
import com.lti.exception.VehicleRegServiceException;
import com.lti.service.VehicleRegServiceInterface;

/**
 * Vehicle Registration controller class will interact with angular frontend.
 * Get info from forms
 * @author Urjita Kerkar
 */
@CrossOrigin
@RestController
public class VehicleRegController {
	
	@Autowired
	private VehicleRegServiceInterface vehicleRegServe;
	
	@PostMapping("/addRegVehicle")
	public VehicleRegInfo addVehicleReg(@RequestBody VehicleRegisteredInfo vr ) {
    try {
            VehicleRegisteredInfo v2 = vehicleRegServe.addNewVehicleRegDet(vr);
		    VehicleRegInfo vh = new VehicleRegInfo();
			vh.setStatus(true);
			vh.setMessage("Vehicle Registered Successfully");
			vh.setRegNo(v2.getRegistrationNo());
			vh.setDateOfReg(v2.getRegistrationDate());
	
			return vh;		
    }
    catch(VehicleRegServiceException ve) {
    	VehicleRegInfo vh = new VehicleRegInfo();
		vh.setStatus(false);
		vh.setMessage(ve.getMessage());
		
		return vh;	
    }

}
}

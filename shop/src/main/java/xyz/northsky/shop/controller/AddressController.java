package xyz.northsky.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.northsky.shop.entity.Address;
import xyz.northsky.shop.service.AddressService;
import xyz.northsky.shop.utils.ResponseCode;
import xyz.northsky.shop.utils.ResponseMessage;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage addAddressForUser(Address address){
        addressService.saveAddressForUser(address);
        return new ResponseMessage().code(ResponseCode.OK).data(address.getId());
    }

    @RequestMapping(value = "/address/{addressId}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseMessage deleteAddressForUser(@PathVariable("addressId") Integer addressId) {
        ResponseMessage responseMessage = new ResponseMessage();
        return responseMessage.code(addressService.deleteAddressForUser(addressId) ? ResponseCode.OK : ResponseCode.NO);
    }

}

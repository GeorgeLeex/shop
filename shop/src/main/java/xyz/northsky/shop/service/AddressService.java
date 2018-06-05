package xyz.northsky.shop.service;

import xyz.northsky.shop.entity.Address;

import java.util.List;

public interface AddressService {

    boolean saveAddressForUser(Address address);

    List<Address> selectAddressByUserId(Integer userId);

    boolean deleteAddressForUser(Integer addressId);

}

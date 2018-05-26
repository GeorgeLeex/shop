package xyz.northsky.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.northsky.shop.dao.AddressMapper;
import xyz.northsky.shop.entity.Address;
import xyz.northsky.shop.entity.AddressExample;
import xyz.northsky.shop.service.AddressService;

import java.util.Collections;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired(required = false)
    private AddressMapper addressMapper;

    @Override
    public boolean saveAddressForUser(Address address) {
        return addressMapper.saveAddressForUser(address) > 0;
    }

    @Override
    public List<Address> selectAddressByUserId(Integer userId) {
        List<Address> addresses = Collections.emptyList();
        if (userId != null) {
            AddressExample addressExample = new AddressExample();
            addressExample.createCriteria().andUserIdEqualTo(userId).andStatusEqualTo("1");
            addresses = addressMapper.selectByExample(addressExample);
        }
        return addresses;
    }

    @Override
    public boolean deleteAddressForUser(Integer addressId) {
        if (addressId == null) {
            return false;
        }
        Address address = new Address();
        address.setId(addressId);
        address.setStatus("0");
        return addressMapper.updateByPrimaryKeySelective(address) > 0;
    }
}

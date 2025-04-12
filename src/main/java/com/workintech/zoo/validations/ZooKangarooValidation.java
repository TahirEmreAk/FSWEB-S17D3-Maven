package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.apache.http.HttpStatus;

import java.net.http.HttpRequest;
import java.util.Map;

public class ZooKangarooValidation {

    public static void isIdValid(Integer id) {
        if (id == null || id < 0){
            throw new ZooException("id is not valid: " + id, HttpStatus.SC_BAD_REQUEST);
        }
    }

    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, Integer id, boolean existence) {

        if (existence){
            if (!kangaroos.containsKey(id)){
                throw new ZooException("Record is not exist" + id, HttpStatus.SC_NOT_FOUND);
            }
        }
        else{
            if (kangaroos.containsKey(id)){
            throw new ZooException("Record is already exist" + id, HttpStatus.SC_BAD_REQUEST);
        }
    }
}

    public static void checkKangarooWeight(Double weight) {
        if (weight == null || weight <= 0 ){
            throw new ZooException("Weight is invalid: " + weight, HttpStatus.SC_BAD_REQUEST);
        }
    }
    }

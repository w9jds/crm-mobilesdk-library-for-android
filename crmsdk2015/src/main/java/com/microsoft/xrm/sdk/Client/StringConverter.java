package com.microsoft.xrm.sdk.Client;

import java.io.IOException;

import retrofit2.Converter;


class StringConverter implements Converter {

    @Override
    public Object convert(Object value) throws IOException {
        return null;
    }

//    @Override
//    public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
//        try {
//            Scanner scanner = new Scanner(typedInput.in()).useDelimiter("\\A");
//            return scanner.hasNext() ? scanner.next() : "";
//        }
//        catch(Exception ex) {
//            ex.getCause().printStackTrace();
//            return null;
//        }
//    }
//
//    @Override
//    public TypedOutput toBody(Object o) {
//        return null;
//    }
}
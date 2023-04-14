package org.project.fotoalbum.exceptions;

public class PhotoNotFoundException extends RuntimeException{
public PhotoNotFoundException(String message){
    super(message);
}
}

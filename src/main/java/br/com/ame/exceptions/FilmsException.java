package br.com.ame.exceptions;

public class FilmsException  extends RuntimeException{


        public FilmsException(final String message) {
            super(String.format("Films [%s].notFound", message));
        }
}



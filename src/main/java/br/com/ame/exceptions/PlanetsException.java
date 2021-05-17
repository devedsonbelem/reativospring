package br.com.ame.exceptions;

public class PlanetsException extends RuntimeException {

    public PlanetsException(final String message) {
                super(String.format("planeta [%s].notFound", message));
    }
}

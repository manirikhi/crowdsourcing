package com.crowdsourcing.exception;

public enum ErrorCodes {

        // Scheduler Service related errors
        INFO_NOT_FOUND(1, "[%s] information is not available."),
        CREATE_ERROR(2, "Error ocurred while creating the [%s]."),
        UPDATE_ERROR(3, "Error ocurred while updating the [%s]."),
        DELETE_ERROR(4, "Error Ocurred while deleting the [%s]."),
        GET_ERROR(5, "Error Ocurred while fetching the [%s].");
        
        private final int code;
        private final String description;


        private ErrorCodes(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public String getCode() {
            return "[E"+code+"]";
        }

        @Override
        public String toString() {
            return "[E"+code+"] "+description;
        }

        public String format(Object... args) {
            return "[E"+code+"] "+ String.format(description, args);
        }
}

package edu.hw2.Task4;

public class Calling {
    private Calling() {
    }

    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        StackTraceElement caller = stackTrace[1];
        String callerClassName = caller.getClassName();
        String callerMethodName = caller.getMethodName();

        return new CallingInfo(callerClassName, callerMethodName);
    }

    public record CallingInfo(String className, String methodName) {
    }
}

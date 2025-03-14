package lab3.Greeter;

/**
 * The {@code Greeter} class represents a runnable task that prints greeting messages.
 * It implements the {@link Runnable} interface, allowing it to be executed in a separate thread.
 *
 * <p>The class is initialized with a specific number of messages to print and a target name
 * to greet. The {@link #run()} method iterates through the specified number of messages,
 * printing a greeting for each iteration.</p>
 */
public class Greeter implements Runnable {
    private final int messagesCount;
    private final String greetingTarget;

    /**
     * Constructs a new {@code Greeter} instance with the specified parameters.
     *
     * @param messagesCount  the number of greeting messages to print
     * @param greetingTarget the name or entity to greet in the messages
     */
    public Greeter(int messagesCount, String greetingTarget) {
        this.messagesCount = messagesCount;
        this.greetingTarget = greetingTarget;
    }

    /**
     * Executes the greeting task. This method iterates through the specified number of messages
     * ({@code messagesCount}) and prints a greeting message for each iteration. The greeting
     * message includes the {@code greetingTarget}.
     *
     * <p>This method is called when the {@code Greeter} instance is executed as a {@link Runnable}
     * task, typically in a separate thread.</p>
     */
    @Override
    public void run() {
        for (int i = 0; i < this.messagesCount; i++) {
            System.out.println("Hello " + greetingTarget);
        }
    }
}

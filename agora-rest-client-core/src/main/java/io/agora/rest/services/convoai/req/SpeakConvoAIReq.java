package io.agora.rest.services.convoai.req;

/**
 * @brief Request Body parameters for calling the Conversational AI engine speak
 *        API
 * @since v0.4.0
 */
public class SpeakConvoAIReq {

    /**
     * The text content to be spoken, with a maximum length of 512 bytes.(Required)
     */
    private String text;

    /**
     * The priority of the speech behavior, which supports the following values
     * (Optional):
     * <p>
     * - "INTERRUPT" (default): High priority, interrupt and speak. The agent will
     * terminate the current interaction and speak the message directly.
     * <p>
     * - "APPEND": Middle priority, append and speak. The agent will speak the
     * message after the current interaction.
     * <p>
     * - "IGNORE": Low priority, speak when idle. If the agent is currently
     * interacting, it will directly ignore and discard the message to be spoken;
     * only when the agent is not interacting will it speak the message.
     */
    private String priority;

    /**
     * Whether to allow the user to speak to interrupt the agent's speech
     * (Optional):
     * <p>
     * - true (default): Allow.
     * <p>
     * - false: Disallow.
     */
    private Boolean interrupt;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String text;
        private String priority;
        private Boolean interrupt;

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder priority(String priority) {
            this.priority = priority;
            return this;
        }

        public Builder interrupt(Boolean interrupt) {
            this.interrupt = interrupt;
            return this;
        }

        public SpeakConvoAIReq build() {
            return new SpeakConvoAIReq(this);
        }
    }

    private SpeakConvoAIReq(Builder builder) {
        setText(builder.text);
        setPriority(builder.priority);
        setInterrupt(builder.interrupt);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setInterrupt(Boolean interrupt) {
        this.interrupt = interrupt;
    }

    public String getText() {
        return text;
    }

    public String getPriority() {
        return priority;
    }

    public Boolean getInterrupt() {
        return interrupt;
    }

}

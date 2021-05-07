package net.rgsu.exam.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class LogResponse {

    @JsonProperty("error")
    private String error;

    @JsonProperty("logs")
    private List<Log> logs;

    public LogResponse() {}

    public LogResponse(String error, List<Log> logs) {
        this.error = error;
        this.logs = logs;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}

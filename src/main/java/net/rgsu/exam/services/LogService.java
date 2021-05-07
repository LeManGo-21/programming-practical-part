package net.rgsu.exam.services;

import net.rgsu.exam.models.Log;
import net.rgsu.exam.models.LogResponse;
import net.rgsu.exam.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LogService {

    public static final String URL = "http://www.dsdev.tech/logs/";

    @Autowired
    private LogRepository repository;

    public void test(){
        System.out.println("Test in LogService!");
        repository.test();
    }

    public void getLogs(String logDate){
        String url = URL.concat(logDate);

        System.out.println("Запрос на: " + url);
        RestTemplate logRequest = new RestTemplate();
        ResponseEntity<LogResponse> response = logRequest.getForEntity(url, LogResponse.class);

        if (response.getStatusCode().equals(HttpStatus.OK) &&
                response.getBody() != null) {
            saveLogs(response.getBody());
        } else {
            System.out.println(response.getStatusCode());
        }
    }

    public void saveLogs(LogResponse response){
        if (response.getError() == null ||
                response.getError().isEmpty()){

            List<Log> logs = response.getLogs();
            logs = mergeSortLogs(logs);
            System.out.println(logs);
            //repository.saveAll(logs);
            System.out.println("Сохранено " + logs.size() + " логов");
        } else {
            System.out.println(response.getError());
        }
    }

    private List<Log> mergeSortLogs(List<Log> logs){
        Deque<List<Log>> deque = new ArrayDeque<>();
        for (Log l : logs){
            deque.addLast(new ArrayList<>(List.of(l)));
        }

        while (deque.size() > 1){
            deque.addLast(merge(deque.removeFirst(), deque.removeFirst()));
        }
        return deque.removeFirst();
    }

    private List<Log> merge(List<Log> a, List<Log> b){
        List<Log> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()){
            if (a.get(i).getCreatedAt().compareTo(b.get(j).getCreatedAt()) > 0) {
                mergedList.add(b.get(j));
                j++;
            } else {
                mergedList.add(a.get(i));
                i++;
            }
        }

        if (i < a.size()) {
            mergedList.addAll(a.subList(i, a.size()));
        } else if (j < b.size()){
            mergedList.addAll(b.subList(j, b.size()));
        }

        return mergedList;
    }
}

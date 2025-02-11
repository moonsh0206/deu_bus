package org.example.deu_station.controller;

import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import java.net.URI;

@Controller
public class BusanBusController {

    @GetMapping("/bus-info")
    public String getBusInfo(Model model) {
        try {
            String apiUrl = "https://apis.data.go.kr/6260000/BusanBIMS/stopArrByBstopid"
                    + "?serviceKey=TB7e8OhLvCvLCCq3%2BdujPm02GcyUdrUlXBHnV5rbRNyCbi5hNqacp%2BUc6Z4vkkQ8TC77KLU14xdwQNr3zmrDSQ%3D%3D"
                    + "&bstopid=505780000";

            RestTemplate restTemplate = new RestTemplate();

            // 1️⃣ HTTP 헤더 추가
            HttpHeaders headers = new HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/119.0.0.0 Safari/537.36");
            headers.set("Accept", "*/*");

            HttpEntity<String> entity = new HttpEntity<>(headers);

            // 2️⃣ URL을 URI 객체로 변환 (자동 인코딩 방지)
            URI uri = new URI(apiUrl);

            // 3️⃣ API 요청
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            // 4️⃣ 결과 처리
            model.addAttribute("xmlData", response.getBody()); // XML 응답 전달
        } catch (Exception e) {
            model.addAttribute("xmlData", "API 호출 중 오류 발생: " + e.getMessage());
        }

        return "bus-info"; // bus-info.html로 이동
    }
}
package com.ncovid.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ndtun
 * @package com.ncovid.util
 * @project NCovidData
 * @Date 25/07/2021
 * description class: all province of Vietnam
 */

@Service
public class ProvinceOfVietnam {

  public static Logger logger = LoggerFactory.getLogger(ProvinceOfVietnam.class);

  @EventListener(ApplicationReadyEvent.class)
  public static List<String> getAllProvince() throws IOException, InterruptedException {
    logger.info("Stating get all province of Vietnam");
    JSONArray dataJsonProvince = new JSONArray(Util.fetchDataJson(Util.urlDataByCurrent));
    List<String> listProvince = new ArrayList<>();
    for (int i = 0; i < dataJsonProvince.length(); i++ ){
      JSONObject province = (JSONObject) dataJsonProvince.get(i);
      listProvince.add(province.get("tinh").toString());
    }

    return listProvince;
  }

}

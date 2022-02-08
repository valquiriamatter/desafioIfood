package com.ifood.iFood.adapter;

import com.ifood.iFood.models.Spotify;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/music")
public class MusicService {

    private final MusicClient musicClient;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{categoria}", method = RequestMethod.GET)
    public Spotify getSpotify(@PathVariable String categoria) {

        //chamar o metodo que retorna o token
        String token = "Bearer BQCJTUU_X9S4o4aqk2Bi4I0lvWu53fSnmYxge7ndI0Dhb6ky-BfkZhmB5ihlGohqVFrxh9PnyAC8Kb4Fd8U";
        return musicClient.getSpotify(token, categoria);
    }



//    @ResponseStatus(HttpStatus.OK)
//    @RequestMapping(value = "/{categoria}", method = RequestMethod.GET, headers = {"myHeader=value"})
//    public Spotify getSpotify(@PathVariable String categoria) {
//        String token = "Bearer BQAY3vpqludc_vD9fW1HF92DQz3i0OIeUVcvSd9YKuSW0E-5Yx3NtF7kxmjN86xDpWnv-ppNWvXqRtwE8Pk";
//        return musicClient.getSpotify(token, categoria);
//    }

}



package com.audio.stream.media.audiostreamingmedia.converter;

import com.audio.stream.media.audiostreamingmedia.dtos.ArtistDto;
import com.audio.stream.media.audiostreamingmedia.entities.Artist;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArtistConverter {

    private final ModelMapper modelMapper;

    public ArtistConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArtistDto entityToDto(Artist artist) {
        ArtistDto artistDto = modelMapper.map(artist, ArtistDto.class);
        return artistDto;
    }

    public List<ArtistDto> entityToDto(List<Artist> artists) {
        return artists.stream().map(artist -> entityToDto(artist)).collect(Collectors.toList());
    }
}

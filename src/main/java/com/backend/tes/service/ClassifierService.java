package com.backend.tes.service;

import com.backend.tes.api.dto.ClassifierDto;
import com.backend.tes.api.mapper.ClassifierMapper;
import com.backend.tes.domain.Brand;
import com.backend.tes.domain.Color;
import com.backend.tes.domain.PriceInterval;
import com.backend.tes.repository.BrandRepository;
import com.backend.tes.repository.ColorRepository;
import com.backend.tes.repository.PriceIntervalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassifierService {

    private final ColorRepository colorRepository;
    private final BrandRepository brandRepository;
    private final PriceIntervalRepository priceIntervalRepository;

    private final ClassifierMapper classifierMapper;

    public ClassifierDto findAllClassifiers() {
        List<Color> colors = colorRepository.findAll();
        List<Brand> brands = brandRepository.findAll();
        List<PriceInterval> priceIntervals = priceIntervalRepository.findAll();

        return classifierMapper.classifiersToClassifierDto(brands, colors, priceIntervals);
    }

}

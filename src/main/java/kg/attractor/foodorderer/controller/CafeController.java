package kg.attractor.foodorderer.controller;

import kg.attractor.foodorderer.annotations.ApiPageable;
import kg.attractor.foodorderer.dto.CafeDTO;
import kg.attractor.foodorderer.dto.DishDTO;
import kg.attractor.foodorderer.service.CafeService;
import kg.attractor.foodorderer.service.DishService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/cafes")
@AllArgsConstructor
public class CafeController {
    private final DishService dishService;
    private final CafeService cafeService;

    @ApiPageable
    @GetMapping
    public Page<CafeDTO> getCafes(@ApiIgnore Pageable pageable){
        return cafeService.getCafes(pageable);
    }

    @ApiPageable
    @GetMapping("/{cafeId}/dishes")
    public Slice<DishDTO> getDishes(@ApiIgnore Pageable pageable, @PathVariable String cafeId){
        return dishService.getDishes(pageable, cafeId);
    }
}

package kg.attractor.foodorderer.service;

import kg.attractor.foodorderer.dto.CafeDTO;
import kg.attractor.foodorderer.model.Cafe;
import kg.attractor.foodorderer.repository.CafeRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CafeService {
    private final CafeRepo cafeRep;

    public Page<CafeDTO> getCafes(Pageable pageable){

        Page<Cafe> cafes = cafeRep.findAll(pageable);

        return cafes.map(CafeDTO::from);
    }


}

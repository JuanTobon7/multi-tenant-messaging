package multi_tenant_back.tenant_api.Barbershops.Base.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShops;
import multi_tenant_back.tenant_api.Barbershops.Base.Model.BarberShopsDto;
import multi_tenant_back.tenant_api.Barbershops.Base.Service.BarberShopsService;
import multi_tenant_back.tenant_api.utils.response.ApiMessages;
import multi_tenant_back.tenant_api.utils.response.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/barbershops")
@RequiredArgsConstructor
public class ControllerBarberShops {
    private final BarberShopsService barberShopsService;
    private final static String location = "/barbershops/";
    @PostMapping
    public ResponseEntity<ApiResponse<BarberShops>> createBarberShop(@Valid @RequestBody BarberShopsDto barberShopsDto) {
            BarberShops barberShops = barberShopsService.createBarberShop(barberShopsDto);
            return ResponseEntity
                    .created(URI.create(location+barberShops.getId()))
                    .body(ApiResponse.success(ApiMessages.RESOURCE_CREATED,barberShops));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<BarberShops>>> findAllBarberShops(Pageable pageable) {
            List<BarberShops> barberShops = barberShopsService.findAllBarberShops(pageable);
            if(barberShops.isEmpty()) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(ApiMessages.RESOURCE_NOT_FOUND, null));
            }
            return ResponseEntity.ok(ApiResponse.success(ApiMessages.RESOURCE_FOUND,barberShops));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<BarberShops>> updateBarberShop(
            @RequestParam(required = true) UUID id,
            @Valid @RequestBody BarberShopsDto barberShopsDto
    ) {
            BarberShops barberShops = barberShopsService.updateBarberShop(barberShopsDto,id);
            return ResponseEntity.ok(ApiResponse.success(ApiMessages.RESOURCE_UPDATED,barberShops));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<Object>> deleteBarberShop(@RequestParam(required = true) UUID id){
            barberShopsService.deleteBarberShop(id);
            return ResponseEntity.ok(ApiResponse.success(ApiMessages.RESOURCE_DELETED));
    }
}
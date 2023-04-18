package datn.qlkt.dto.dtos;

import datn.qlkt.ultis.NumberUtils;

import java.lang.reflect.Array;

public record WareHouseFilter (
        String productName,
        String productId,
        String isActive,
        Integer page,
        Integer size
) {
    @Override
    public Integer page() {
        return NumberUtils.isNull(page) ? 0 : (page - 1);
    }
}

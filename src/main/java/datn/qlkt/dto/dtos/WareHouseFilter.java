package datn.qlkt.dto.dtos;

import datn.qlkt.ultis.NumberUtils;

public record WareHouseFilter (
        String productName,
        String productId,
        Integer isActive,
        Integer page,
        Integer size
) {
    @Override
    public Integer page() {
        return NumberUtils.isNull(page) ? 0 : (page - 1);
    }
}

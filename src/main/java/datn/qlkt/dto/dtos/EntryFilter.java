package datn.qlkt.dto.dtos;

import datn.qlkt.ultis.NumberUtils;

import java.util.Date;

public record EntryFilter(
       String idEntry,
       String nameProduct,
       String nameProducer,
       String startDate,
       String endDate,
       Integer page,
       Integer size
) {
    @Override
    public Integer page() {
        return NumberUtils.isNull(page) ? 0 : (page - 1);
    }
}

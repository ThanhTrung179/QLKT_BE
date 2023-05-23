package datn.qlkt.dto.dtos;

import datn.qlkt.ultis.NumberUtils;

public record SaleExportFilter(
        String idExport,
        String nameProduct,
        String nameProducer,
        String creator,
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

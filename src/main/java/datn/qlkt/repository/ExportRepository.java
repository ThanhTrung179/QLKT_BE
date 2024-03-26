package datn.qlkt.repository;

import datn.qlkt.model.Entry;
import datn.qlkt.model.Export;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ExportRepository extends JpaRepository<Export, Long> {

    @Query(value = "SELECT e, w, p, pr FROM Export e " +
            "LEFT JOIN FETCH e.wareHouseExports w " +
            "LEFT JOIN FETCH w.product p " +
            "LEFT JOIN FETCH p.producers pr " +
            "WHERE e.is_active in (0, 1) " +
            "AND (:idExport IS NULL OR e.idExport LIKE %:idExport%) " +
            "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
            "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) " +
            "AND (:startDate IS NULL OR :endDate IS NULL OR e.inTime BETWEEN :startDate AND :endDate)",
            countQuery = "SELECT COUNT(DISTINCT e) FROM Export e " +
                    "LEFT JOIN e.wareHouseExports w " +
                    "LEFT JOIN w.product p " +
                    "LEFT JOIN p.producers pr " +
                    "WHERE e.is_active in (0, 1) " +
                    "AND (:idExport IS NULL OR e.idExport LIKE %:idEntry%) " +
                    "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
                    "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) " +
                    "AND (:startDate IS NULL OR :endDate IS NULL OR e.inTime BETWEEN :startDate AND :endDate)")
    Page<Export> getAllExportList(Pageable pageable, String nameProduct, String idExport, String nameProducer, Date startDate, Date endDate);

    @Query(value = "SELECT e, w, p, pr FROM Export e " +
            "LEFT JOIN FETCH e.wareHouseExports w " +
            "LEFT JOIN FETCH w.product p " +
            "LEFT JOIN FETCH p.producers pr " +
            "WHERE e.is_active in (0, 1) " +
            "AND (:idExport IS NULL OR e.idExport LIKE %:idExport%) " +
            "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
            "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) ",
            countQuery = "SELECT COUNT(DISTINCT e) FROM Export e " +
                    "LEFT JOIN e.wareHouseExports w " +
                    "LEFT JOIN w.product p " +
                    "LEFT JOIN p.producers pr " +
                    "WHERE e.is_active in (0, 1) " +
                    "AND (:idExport IS NULL OR e.idExport LIKE %:idExport%) " +
                    "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
                    "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) ")
    Page<Export> getAllExportListNotDate(Pageable pageable, String nameProduct, String idExport, String nameProducer);


    @Query(value = "SELECT e, w, p, pr FROM Export e " +
            "LEFT JOIN FETCH e.wareHouseExports w " +
            "LEFT JOIN FETCH w.product p " +
            "LEFT JOIN FETCH p.producers pr " +
            "WHERE e.is_active in (1) " +
            "AND (:idExport IS NULL OR e.idExport LIKE %:idExport%) " +
            "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
            "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) " +
            "AND (:creator IS NULL OR e.creator = :creator OR :creator = '') " +
            "AND (:startDate IS NULL OR :endDate IS NULL OR e.inTime BETWEEN :startDate AND :endDate)",
            countQuery = "SELECT COUNT(DISTINCT e) FROM Export e " +
                    "LEFT JOIN e.wareHouseExports w " +
                    "LEFT JOIN w.product p " +
                    "LEFT JOIN p.producers pr " +
                    "WHERE e.is_active in (1) " +
                    "AND (:idExport IS NULL OR e.idExport LIKE %:idEntry%) " +
                    "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
                    "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) " +
                    "AND (:creator IS NULL OR e.creator = :creator OR :creator = '') " +
                    "AND (:startDate IS NULL OR :endDate IS NULL OR e.inTime BETWEEN :startDate AND :endDate)")
    Page<Export> getAllSaleExportList(Pageable pageable, String nameProduct, String idExport, String nameProducer,String creator, Date startDate, Date endDate);

    @Query(value = "SELECT SUM(e.moneyTotal) AS totalMoney, e, w, p, pr FROM Export e " +
            "LEFT JOIN FETCH e.wareHouseExports w " +
            "LEFT JOIN FETCH w.product p " +
            "LEFT JOIN FETCH p.producers pr " +
            "WHERE e.is_active in (1) " +
            "AND (:idExport IS NULL OR e.idExport LIKE %:idExport%) " +
            "AND (:nameProduct IS NULL OR p.productName LIKE %:nameProduct%) " +
            "AND (:nameProducer IS NULL OR pr.producerName LIKE %:nameProducer%) " +
            "AND (:creator IS NULL OR e.creator = :creator OR :creator = '') " +
            "AND (:startDate IS NULL OR :endDate IS NULL OR e.inTime BETWEEN :startDate AND :endDate)")
    Long calculateTotalMoney(String nameProduct, String idExport, String nameProducer, String creator, Date startDate, Date endDate);
    @Modifying
    @Query("UPDATE Export e SET e.is_active = :is_active where e.id = :id")
    void updateExportActive(Integer is_active, Long id);
}

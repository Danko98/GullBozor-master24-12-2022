package uz.gullbozor.gullbozor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.gullbozor.gullbozor.entity.Announce;
import uz.gullbozor.gullbozor.entity.ShopEntity;

import java.util.Optional;

public interface ShopRepo extends JpaRepository<ShopEntity, Long> {

    boolean existsByShopName(String shopName);

    Optional<ShopEntity> findBySellerId(Long sellerId);


}

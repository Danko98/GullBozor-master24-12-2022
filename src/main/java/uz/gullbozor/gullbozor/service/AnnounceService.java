package uz.gullbozor.gullbozor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.gullbozor.gullbozor.apiResponse.ApiResponse;
import uz.gullbozor.gullbozor.dto.AnnounceDto;
import uz.gullbozor.gullbozor.dto.FilterDto;
import uz.gullbozor.gullbozor.entity.*;
import uz.gullbozor.gullbozor.repository.*;

import java.util.*;

@Service
public class AnnounceService {

    @Autowired
    private AnnounceRepo announceRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RegionRepo regionRepo;

    @Autowired
    private CityRepo cityRepo;

    public ApiResponse addAnnounce(AnnounceDto announceDto) {

//        if (!categoryRepo.existsById(announceDto.getCategoryId())) {
//            return new ApiResponse("Not found announce",false);
//        }
//
//        if (!userRepo.existsById(announceDto.getSellerId())) {
//            return new ApiResponse("Not found Seller",false);
//        }
//
//
//        Optional<Category> optionalCategory = categoryRepo.findById(announceDto.getCategoryId());
//        Optional<UserEntity> optionalSellerEntity = userRepo.findById(announceDto.getSellerId());

        if (!regionRepo.existsById(announceDto.getRegionId())) {
            return new ApiResponse("Bunday viloyat topilmadi",false);
        }

        if (!cityRepo.existsById(announceDto.getCityId())) {
            return new ApiResponse("Bunday tuman topilmadi",false);
        }

        RegionEntity regionEntity = regionRepo.getById(announceDto.getRegionId());
        CityEntity cityEntity = cityRepo.getById(announceDto.getCityId());

        Date date = new Date();
        Announce announce = new Announce();


        announce.setCreateAt(date.getTime());
        announce.setRegionName(regionEntity.getName());
        announce.setCityName(cityEntity.getName());
        announce.setPrice(announceDto.getPrice());
        announce.setActive(true);
        announce.setTitle(announceDto.getTitle());
        announce.setImage1(announceDto.getImage1());
        announce.setImage2(announceDto.getImage2());
        announce.setImage3(announceDto.getImage3());
        announce.setImage4(announceDto.getImage4());
        announce.setImage5(announceDto.getImage5());
        announce.setImage6(announceDto.getImage6());
        announce.setImage7(announceDto.getImage7());
        announce.setImage8(announceDto.getImage8());
        announce.setDescription(announceDto.getDescription());
        announce.setPhoneNumber(announceDto.getPhoneNumber());
        announce.setTopNumber(announceDto.getTopNumber());
        announce.setDepartment(announceDto.getDepartment());
        announce.setCategoryId(announceDto.getCategoryId());
        announce.setRegionId(announceDto.getRegionId());
        announce.setCityId(announceDto.getCityId());
        announce.setShopId(announceDto.getShopId());
        announce.setSellerId(announceDto.getSellerId());
        announce.setHeight(announceDto.getHeight());
        announce.setDiameter(announceDto.getDiameter());
        announce.setWeight(announceDto.getWeight());
        announce.setCustomer(announceDto.isCustomer());
        announce.setWithPot(announceDto.isWithPot());
        announce.setWithFertilizer(announceDto.isWithFertilizer());

        announceRepo.save(announce);
        return new ApiResponse("Successfully saved",true);

    }

    public ApiResponse editAnnounce(AnnounceDto announceDto, Long id) {

        if (!announceRepo.existsById(id)) {
            return new ApiResponse("Not found announce",false);
        }

        if (!categoryRepo.existsById(announceDto.getCategoryId())) {
            return new ApiResponse("Not found announce",false);
        }

        Optional<Announce> optionalAnnounce = announceRepo.findById(id);

        Announce announce = optionalAnnounce.get();

        announce.setPrice(announceDto.getPrice());
        announce.setActive(true);
        announce.setTitle(announceDto.getTitle());
        announce.setImage1(announceDto.getImage1());
        announce.setImage2(announceDto.getImage2());
        announce.setImage3(announceDto.getImage3());
        announce.setImage4(announceDto.getImage4());
        announce.setImage5(announceDto.getImage5());
        announce.setImage6(announceDto.getImage6());
        announce.setImage7(announceDto.getImage7());
        announce.setImage8(announceDto.getImage8());
        announce.setDescription(announceDto.getDescription());
        announce.setPhoneNumber(announceDto.getPhoneNumber());
        announce.setTopNumber(announceDto.getTopNumber());
        announce.setDepartment(announceDto.getDepartment());
        announce.setCategoryId(announceDto.getCategoryId());
        announce.setRegionId(announceDto.getRegionId());
        announce.setCityId(announceDto.getCityId());
        announce.setShopId(announceDto.getShopId());
        announce.setSellerId(announceDto.getSellerId());
        announce.setHeight(announceDto.getHeight());
        announce.setDiameter(announceDto.getDiameter());
        announce.setWeight(announceDto.getWeight());
        announce.setCustomer(announceDto.isCustomer());
        announce.setWithPot(announceDto.isWithPot());
        announce.setWithFertilizer(announceDto.isWithFertilizer());
        announce.setAllowed(false);

        announceRepo.save(announce);
        return new ApiResponse("Successfully edited",true);

    }

    public ApiResponse editAnnounceFromAdmin(AnnounceDto announceDto, Long id) {

        if (!announceRepo.existsById(id)) {
            return new ApiResponse("Not found announce",false);
        }

        if (!categoryRepo.existsById(announceDto.getCategoryId())) {
            return new ApiResponse("Not found announce",false);
        }

        Optional<Announce> optionalAnnounce = announceRepo.findById(id);

        Announce announce = optionalAnnounce.get();

        announce.setCallingCount(announceDto.getCallingCount());
        announce.setPrice(announceDto.getPrice());
        announce.setActive(announceDto.isActive());
        announce.setTitle(announceDto.getTitle());
        announce.setImage1(announceDto.getImage1());
        announce.setImage2(announceDto.getImage2());
        announce.setImage3(announceDto.getImage3());
        announce.setImage4(announceDto.getImage4());
        announce.setImage5(announceDto.getImage5());
        announce.setImage6(announceDto.getImage6());
        announce.setImage7(announceDto.getImage7());
        announce.setImage8(announceDto.getImage8());
        announce.setDescription(announceDto.getDescription());
        announce.setPhoneNumber(announceDto.getPhoneNumber());
        announce.setTopNumber(announceDto.getTopNumber());
        announce.setDepartment(announceDto.getDepartment());
        announce.setCategoryId(announceDto.getCategoryId());
        announce.setRegionId(announceDto.getRegionId());
        announce.setCityId(announceDto.getCityId());
        announce.setShopId(announceDto.getShopId());
        announce.setSellerId(announceDto.getSellerId());
        announce.setHeight(announceDto.getHeight());
        announce.setDiameter(announceDto.getDiameter());
        announce.setWeight(announceDto.getWeight());
        announce.setCustomer(announceDto.isCustomer());
        announce.setWithPot(announceDto.isWithPot());
        announce.setWithFertilizer(announceDto.isWithFertilizer());
        announce.setAllowed(announceDto.isAllowed());

        announceRepo.save(announce);
        return new ApiResponse("Successfully edited",true);

    }

    public List<Announce> getIndexPage() {

        List<Announce> topNumber3 = announceRepo.findByTopNumberRandom3();
        List<Announce> topNumber5 = announceRepo.findByTopNumberRandom5();
        List<Announce> topNumber10 = announceRepo.findByTopNumberRandom10();

        List<Announce> topAnnounceList = new ArrayList<>();
        topAnnounceList.containsAll(topNumber3);
        topAnnounceList.containsAll(topNumber5);
        topAnnounceList.containsAll(topNumber10);

        return topAnnounceList;
    }

    public Page<Announce> getAnnounceCustomer(Integer department,int page) {
        Pageable pageable = PageRequest.of(page, 40);
        return announceRepo.findAllByCustomer(true, pageable);
    }

    public Page<Announce> getMyAnnounce(Long sellerId, int page) {
        Pageable pageable = PageRequest.of(page, 40);
        return announceRepo.findAllBySellerId(sellerId, pageable);
    }

    public ApiResponse getAnnounceById(Long id) {
        if (!announceRepo.existsById(id)) {
            return new ApiResponse("Not found announce",false);
        }
        Optional<Announce> optionalAnnounce = announceRepo.findById(id);
        return new ApiResponse(optionalAnnounce.get());
    }

    public Page<Announce> getAnnouncePage(int page) {

        Pageable pageable = PageRequest.of(page, 30, Sort.by(Sort.Direction.ASC,"createAt"));

        return announceRepo.findAll(pageable);
    }

    public Page<Announce> getAnnounceByDepartment(int page, Integer department){
        Pageable pageable = PageRequest.of(page, 30, Sort.by(Sort.Direction.ASC,"createAt"));
        return announceRepo.findAllByDepartment(department,pageable);
    }

    public Page<Announce> getAnnounceByCategory(int page, Long category){
        Pageable pageable = PageRequest.of(page, 30, Sort.by(Sort.Direction.ASC,"createAt"));
        return announceRepo.findAllByCategoryId(category,pageable);
    }

    public List<Announce> getAnnounceList() {
        return announceRepo.findAll();
    }

    public Page<Announce> getAnnounceByShopId(Long shopId, int page) {
        Pageable pageable = PageRequest.of(page, 40);
        return announceRepo.findAllByShopId(shopId, pageable);
    }

    public ApiResponse deleteAnnounceById(Long id) {
        if (!announceRepo.existsById(id)) {
            return new ApiResponse("Not found announce",false);
        }
        announceRepo.deleteById(id);
        return new ApiResponse("Successfully deleted",true);
    }

    public ApiResponse deleteAllByPin(Integer pin) {
        if (pin == 98) {
            announceRepo.deleteAll();
            return new ApiResponse("Barcha elonlar o'chirib yuborlidi",true);
        }else
            return new ApiResponse("pin xato",false);

    }



}

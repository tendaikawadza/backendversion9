/**
 * @author Kumar.Kunal
 */
package io.getarrays.securecapita.purchaserequestnew;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import io.getarrays.securecapita.exception.PurchaseRequestNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Kumar.Kunal
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseRequestNewServiceImpl implements PurchaseRequestNewService {

	private final PurchaseRequestNewRepository purchaseRequestRepository;
	private final ModelMapper modelMapper;
	private final PurchaseRequestMapper mapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<PurchaseRequestDto> saveFile(List<MultipartFile> files, List<PurchaseRequestDto> pEntity)
			throws IOException {
		log.info("Entering saveFile method from Service class '{}' ");
		purchaseRequestRepository.saveFile(files, Arrays.asList(modelMapper.map(pEntity, PurchaseRequestEntity[].class)));
		log.info("Processing saveFile method value in Service class ---- '{}'", pEntity);
		return pEntity;

	}
	
	@Override
	public List<PurchaseResponseDto> findAll() {

		return purchaseRequestRepository.findAll().stream()
				.map(purchase -> modelMapper.map(purchase, PurchaseResponseDto.class)).collect(Collectors.toList());
	}

	@Override
	public PurchaseResponseDto findById(Long id) {

		return modelMapper.map(
				purchaseRequestRepository.findById(id).orElseThrow(PurchaseRequestNotFoundException::new),
				PurchaseResponseDto.class);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseDto insert(PurchaseRequestDto purchaseRequest) {

		return purchaseRequestRepository.save(modelMapper.map(purchaseRequest, PurchaseRequestEntity.class)) > 0
				? new ResponseDto("Purchase Request Created Successfully!")
				: new ResponseDto("Purchase Request Created Failed!");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseDto update(PurchaseRequestDtoId purchaseRequest) {

		return purchaseRequestRepository.update(modelMapper.map(purchaseRequest, PurchaseRequestEntity.class)) > 0
				? new ResponseDto("Purchase Request Updated Successfully!")
				: new ResponseDto("Purchase Request Updated Failed!");
	}

	@Override
	public ResponseDto delete(Long id) {

		return purchaseRequestRepository.deleteById(id) > 0 ? new ResponseDto("Purchase Request Deleted Successfully!")
				: new ResponseDto("Purchase Request Deleted Failed!");
	}

	@Override
	public List<PurchaseResponseDto> findAll(io.getarrays.securecapita.purchaserequestnew.Page page) {
		Stream<PurchaseRequestEntity> stream = purchaseRequestRepository.findAll(page);
		return stream.map(mapper::toDTO).collect(Collectors.toList());
	}

}


package io.getarrays.securecapita.issue;




import io.getarrays.securecapita.issue.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Kumar.Kunal
 */
@Service

@Slf4j
public class IssueServiceImpl implements IssueService {

	private final IssueRepository issueRepository;
	private final ModelMapper modelMapper;
	private final IssueMapper mapper;

	public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper, IssueMapper mapper) {
		this.issueRepository = issueRepository;
		this.modelMapper = modelMapper;
		this.mapper = mapper;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public List<io.getarrays.securecapita.issue.IssueDto > saveFile(List<MultipartFile> files, List<io.getarrays.securecapita.issue.IssueDto> pEntity)
			throws IOException {
		log.info("Entering saveFile method from Service class '{}' ");
		issueRepository.saveFile(files, Arrays.asList(modelMapper.map(pEntity, io.getarrays.securecapita.issue.IssueEntity[].class)));
		log.info("Processing saveFile method value in Service class ---- '{}'", pEntity);
		return pEntity;

	}

//	@Override
//	public List<IssueResponseDto> findAll() {
//
//		return purchaseRequestRepository.findAll().stream()
//				.map(purchase -> modelMapper.map(purchase, PurchaseResponseDto.class)).collect(Collectors.toList());
//	}

//	@Override
//	public List<IssueResponseDto> findAll(io.getarrays.securecapita.issue.Page page) {
//		Stream<IssueEntity> stream = issueRepository.findAll(page);
//		return stream.map(mapper::toDTO).collect(Collectors.toList());
//	}
//	@Override
//	public IssueResponseDto findById(Long id) {
//
//		return modelMapper.map(
//				issueRepository.findById(id).orElseThrow(IssueRequestNotFoundException::new),
//				IssueResponseDto.class);
//	}



	@Override
	public List<IssueResponseDto> findAll(Page page) {
		Stream<IssueEntity> stream = issueRepository.findAll(page);
		return stream.map(mapper::toDTO).collect(Collectors.toList());
	}

	@Override
	public ResponseDto delete(Long id) {

		return issueRepository.deleteById(id) > 0 ? new ResponseDto("Issue Deleted Successfully!")
				: new ResponseDto("Issue Deleted Failed!");
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public ResponseDto update(IssueDtoId issue) {

		return issueRepository.update(modelMapper.map(issue, IssueEntity.class)) > 0
				? new ResponseDto("Issue Request Updated Successfully!")
				: new ResponseDto("Issue Request Updated Failed!");
	}




}

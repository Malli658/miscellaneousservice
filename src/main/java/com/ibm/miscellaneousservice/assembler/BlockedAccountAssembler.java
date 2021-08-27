package com.ibm.miscellaneousservice.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.ibm.miscellaneousservice.dto.model.BlockedAccountModel;
import com.ibm.miscellaneousservice.model.BlockedAccount;
import com.ibm.miscellaneousservice.resources.UserResources;

@Component
public class BlockedAccountAssembler extends RepresentationModelAssemblerSupport<BlockedAccount,BlockedAccountModel>{

	public BlockedAccountAssembler(){
		super(BlockedAccount.class,BlockedAccountModel.class);
	}

	@Override
	public BlockedAccountModel toModel(BlockedAccount entity) {
		BlockedAccountModel bam=instantiateModel(entity);
		bam.add(linkTo(methodOn(UserResources.class).getUser(new Long(entity.getBlockedUserId()))).withRel("blockedUser"));
		return bam;
	}
	
	@Override
	public CollectionModel<BlockedAccountModel> toCollectionModel(Iterable<? extends BlockedAccount> entities) {
		CollectionModel<BlockedAccountModel> mediaModels = super.toCollectionModel(entities);
		return mediaModels;
	}
	
	@Override
	protected BlockedAccountModel instantiateModel(BlockedAccount entity) {
		JMapper<BlockedAccountModel, BlockedAccount> mediaMapper=new JMapper<>(BlockedAccountModel.class, BlockedAccount.class);
		BlockedAccountModel mediaModel=mediaMapper.getDestination(entity);
		return mediaModel;
	}
}

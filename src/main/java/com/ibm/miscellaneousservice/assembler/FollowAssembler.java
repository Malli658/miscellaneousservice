package com.ibm.miscellaneousservice.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.ibm.miscellaneousservice.dto.model.FollowerModel;
import com.ibm.miscellaneousservice.model.Follower;
import com.ibm.miscellaneousservice.resources.UserResources;

@Component
public class FollowAssembler extends RepresentationModelAssemblerSupport<Follower,FollowerModel>{

	public FollowAssembler() {
		super(Follower.class, FollowerModel.class);
	}

	@Override
	public FollowerModel toModel(Follower entity) {
		FollowerModel fm=instantiateModel(entity);
		fm.add(linkTo(methodOn(UserResources.class).getUser(new Long(entity.getUserId()))).withRel("User"));
		fm.add(linkTo(methodOn(UserResources.class).getUser(new Long(entity.getFollowsUserId()))).withRel("FollowsUser"));
		return fm;
	}
	
	@Override
	public CollectionModel<FollowerModel> toCollectionModel(Iterable<? extends Follower> entities) {
		CollectionModel<FollowerModel> mediaModels = super.toCollectionModel(entities);
		return mediaModels;
	}
	
	@Override
	protected FollowerModel instantiateModel(Follower entity) {
		JMapper<FollowerModel, Follower> mediaMapper=new JMapper<>(FollowerModel.class, Follower.class);
		FollowerModel mediaModel=mediaMapper.getDestination(entity);
		return mediaModel;
	}

}

package com.ibm.miscellaneousservice.assembler;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.googlecode.jmapper.JMapper;
import com.ibm.miscellaneousservice.dto.model.NewsFeedModel;
import com.ibm.miscellaneousservice.model.NewsFeed;

@Component
public class NewsFeedAssembler extends RepresentationModelAssemblerSupport<NewsFeed,NewsFeedModel>{

	public NewsFeedAssembler() {
		super(NewsFeed.class, NewsFeedModel.class);
		
	}

	@Override
	public NewsFeedModel toModel(NewsFeed entity) {
		NewsFeedModel model=instantiateModel(entity);
		return model;
	}
	
	@Override
	public CollectionModel<NewsFeedModel> toCollectionModel(Iterable<? extends NewsFeed> entities) {
		CollectionModel<NewsFeedModel> mediaModels = super.toCollectionModel(entities);
		return mediaModels;
	}
	
	@Override
	protected NewsFeedModel instantiateModel(NewsFeed entity) {
		JMapper<NewsFeedModel, NewsFeed> mediaMapper=new JMapper<>(NewsFeedModel.class, NewsFeed.class);
		NewsFeedModel mediaModel=mediaMapper.getDestination(entity);
		return mediaModel;
	}

}

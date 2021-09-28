package com.cg.market.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.market.entites.Proposal;

public interface MarketDaoProposal extends JpaRepository<Proposal, Integer> {

}

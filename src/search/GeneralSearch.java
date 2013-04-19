//
//  GeneralSearch.skeleton
//  javaAgents
//
//  Created by Cara MacNish on 28/07/05.
//  Copyright (c) 2005 CSSE, UWA. All rights reserved.
//

package search;
import agent.*;
import java.util.*;

import wordPlayer.WordNodeInfo;

public abstract class GeneralSearch {

  NodeInfo nodeInfo;
  ArrayList unvisited, visited;

  public GeneralSearch (State startState, NodeInfo nodeInfo) {
    this.nodeInfo = nodeInfo;
    unvisited = new ArrayList();
    unvisited.add(new Node(startState, new Actions()));
    visited = new ArrayList();
  }

  public Node search() {
	  Actions moves;
	  Action move;
	  
	  //Iterating through arrayList for unvisited and possible arcs
	  Node visit, successor;
	  
	  if(unvisited.isEmpty()) return null;
	  while( !unvisited.isEmpty() ) {
		  visit = select();
		  if(nodeInfo.isGoal(visit)) return visit;
		  moves = visit.getState().getActions();
		  
		  Iterator<Action> it = moves.iterator();
		  while(it.hasNext()) {
			  successor = (Node) visit.clone();
			  move = it.next();
			  successor.getState().update(move);
			  insert(successor);
		  }
		  visited.add(visit);
	  }
	  return null;
  }
      
  public abstract Node select ();

  public abstract void insert (Node node);

  
  
}

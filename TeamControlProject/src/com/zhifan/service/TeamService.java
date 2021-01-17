package com.zhifan.service;

import com.zhifan.domain.*;


public class TeamService {
    private static int counter = 1;//generate memberId
    private final int MAX_MEMBER = 5;//max team member amount
    private Programmer[] team = new Programmer[MAX_MEMBER];//save current team member
    private int total = 0;//current number of member in team, total<=5

    public TeamService() {
    }
    //return a copy of the team without null members, avoid encountering error
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        //important
        for (int i = 0; i < total; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER)
            throw new TeamException("Max amount reached...Cannot add this as a member");
        if (!(e instanceof Programmer))
            throw new TeamException("This employee is not Programmer...Cannot add this as a member");

        Programmer p = (Programmer)e;
        
        if (isExist(p))
        	throw new TeamException("This member is already in the team...");
        
        if(p.getStatus().getNAME().equals("BUSY")) {
        	throw new TeamException("This member is in a team already...");
        }else if(p.getStatus().getNAME().equals("VOCATION")) {
        	throw new TeamException("This memebr is on vacation...");
        }


        
        int numOfArch = 0, numOfDsgn = 0, numOfPrg = 0;
        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) numOfArch++;
            else if (team[i] instanceof Designer) numOfDsgn++;
            else if (team[i] instanceof Programmer) numOfPrg++;
        }
        //check member's position
        if (p instanceof Architect) {
            if (numOfArch >= 1) throw new TeamException("This team can only have one architect");
        } else if (p instanceof Designer) {
            if (numOfDsgn >= 2) throw new TeamException("This team can only have two designer");
        } else if (p instanceof Programmer) {
            if (numOfPrg >= 3) throw new TeamException("This team can only have three programmer");
        }
        //new member added successfully 
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
        team[total++] = p;
    }

    private boolean isExist(Programmer p) {
        for (int i = 0; i < total; i++) {
            if (team[i].getId() == p.getId()) return true;
        }

        return false;
    }
    //remove the programmer with memberId
    public void removeMember(int memberId) throws TeamException {
        int n = 0;
      
        for (; n < total; n++) {
            if (team[n].getMemberId() == memberId) {
                team[n].setStatus(Status.FREE);
                break;
            }
        }
        
        if (n == total)
            throw new TeamException("Cannot find this programmer...");
      // adjust the rest of the members's position.
        for (int i = n + 1; i < total; i++) {
            team[i - 1] = team[i];
        }
        team[--total] = null;
    }
}
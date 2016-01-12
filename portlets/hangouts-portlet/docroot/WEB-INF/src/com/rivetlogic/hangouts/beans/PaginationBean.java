/**
 * Copyright (C) 2005-2014 Rivet Logic Corporation.
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; version 3 of the License.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */

package com.rivetlogic.hangouts.beans;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.rivetlogic.hangouts.util.Constants;

/**
 * @author christopherjimenez
 *
 */
public class PaginationBean {
	
	protected OrderByComparator obc;
	protected int start;
	protected int end;
	protected int curPage;
	protected int delta;
	protected int total;
	
	public PaginationBean(){
		start = Constants.DEFAULT_INT_VALUE;
		end = Constants.DEFAULT_DELTA;
		curPage = Constants.DEFAULT_ELEMENT_VALUE;
		delta = end;
	}
	
	public OrderByComparator getObc() {
		return obc;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getCurPage() {
		return curPage;
	}

	public int getDelta() {
		return delta;
	}
	
	public int getTotal(){
		return total;
	}

	public void setObc(OrderByComparator obc) {
		this.obc = obc;
	}
	
	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public void setDelta(int delta) {
		this.delta = delta;
	}	

	public void setTotal(int total){
		this.total = total;
	}
	
	public void load(){
		
	}
}

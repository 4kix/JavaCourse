package by.iba.holder;

import java.util.List;

import by.iba.entity.UniversityMember;

public interface HolderInterface {
		public void add(UniversityMember leftMember, UniversityMember rightMember);
		public List<UniversityMember> getLeftByRight(UniversityMember rightMember);
		public List<UniversityMember> getRightByLeft(UniversityMember leftMember);
}

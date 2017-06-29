package by.epam.nikolaev.ilya.bean;

public class BlockOfCode implements PartOfText {
	String blockCode;

	public BlockOfCode(String blockCode) {
		super();
		this.blockCode = blockCode;
	}

	public String getBlockCode() {
		return blockCode;
	}

	public void setBlockCode(String blockCode) {
		this.blockCode = blockCode;
	}

	@Override
	public String toString() {
		return blockCode;
	}
	
	

}

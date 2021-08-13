package com.example.market.util;

import lombok.Data;

@Data
public class Pager {

    private long totalRecord;

    private int pageScale; // 한 화면에 보여 줄 데이터의 수
    private int blockScale;

    private int totalPage;
    private int curPage;

    private int blockBegin;
    private int blockEnd;

    private boolean showLeftEllipsis;
    private boolean showPageBlock;
    private boolean showEndPage;
    private boolean showRightEllipsis;

    public Pager(long totalRecord, int curPage) {
        this(totalRecord, curPage, 10);
    }

    public Pager(long totalRecord, int curPage, int pageScale) {
        this(totalRecord, curPage, pageScale, 3);
    }

    public Pager(long totalRecord, int curPage, int pageScale, int blockScale) {
        this.totalRecord = totalRecord;
        this.pageScale = pageScale;
        this.blockScale = blockScale;
        this.curPage = curPage;

        this.showPageBlock = true;
        this.showEndPage = true;

        init(totalRecord);
    }

    private void init(long totalRecord) {
        totalPage = totalRecord % pageScale == 0 ?
                (int) (totalRecord / pageScale) :
                (int) (totalRecord / pageScale) + 1;

        if (totalPage < 1) totalPage = 1;

        if (getTotalPage() == 1) {
            blockBegin = 1;
            blockEnd = 1;

            showLeftEllipsis = false;
            showPageBlock = false;
            showRightEllipsis = false;
            showEndPage = false;
            return;
        }

        if (getTotalPage() <= getBlockScale()) {
            blockBegin = 2;
            blockEnd = getTotalPage();

            showLeftEllipsis = false;
            showRightEllipsis = false;
            showEndPage = false;
            return;
        }

        int leftCount = blockScale / 2;
        blockBegin = Math.max(2, getCurPage() - leftCount);

        int rightCount = blockScale - leftCount - 1;
        blockEnd = Math.min(getCurPage() + rightCount, getTotalPage() - 1);

        blockBegin += Math.min(0, (getTotalPage() - getCurPage() - rightCount));
        blockEnd += (getCurPage() - 1) - leftCount < 0 ? Math.abs((getCurPage() - 1) - leftCount) : 0;

        showLeftEllipsis = getCurPage() - (leftCount + 1) > 1;
        showRightEllipsis = getCurPage() + rightCount < getTotalPage() - 1;
    }

    public int getBlockBeginForFront() {
        int blockScale = (curPage / 10);
        blockBegin = blockScale * 10 + 1;
        return blockBegin;
    }

    public int getBlockEndForFront() {
        int blockScale = (curPage / 10);
        blockEnd = Math.min(totalPage, (blockScale + 1) * 10);
        return blockEnd;
    }

    public boolean isActiveLeftArrow() {
        return curPage != 1;
    }

    public boolean isActiveRightArrow() {
        return curPage != totalPage;
    }

    public long pageOffset() {
        return getTotalRecord() - ((getCurPage() - 1) * getPageScale());
    }

    public DataMessage toMessage() {
        return new DataMessage()
                .addData("hasPrev", isActiveLeftArrow())
                .addData("hasNext", isActiveRightArrow())
                .addData("totalElement", totalRecord)
                .addData("blockStart", getBlockBeginForFront())
                .addData("blockEnd", getBlockEndForFront())
                .addData("curPage", curPage)
                .addData("pageOffset", pageOffset());
    }

}

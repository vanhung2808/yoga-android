//package com.stdio.hue.yoga.modules.main.ui.actions;
//
//import com.stdio.hue.yoga.data.models.Poses;
//
//import java.util.List;
//
//import io.reactivex.subjects.PublishSubject;
//
///**
// * Created by dungbeo on 1/13/2020.
// */
//public class PosesOfPosesAction {
//    public static final PublishSubject<PosesOfPosesAction> publisher = PublishSubject.create();
//    private boolean isLoading;
//    private String errorMessage;
//    private List<Poses> poses;
//
//    public static PosesOfPosesAction isLoading(boolean isLoading) {
//        PosesOfPosesAction action = new PosesOfPosesAction();
//        action.isLoading = isLoading;
//        return action;
//    }
//
//    public static PosesOfPosesAction error(String mess) {
//        PosesOfPosesAction action = new PosesOfPosesAction();
//        action.errorMessage = mess;
//        return action;
//    }
//
//    public static PosesOfPosesAction setPoses(List<Poses> poses) {
//        PosesOfPosesAction action = new PosesOfPosesAction();
//        action.poses = poses;
//        return action;
//    }
//
//    public boolean isLoading() {
//        return isLoading;
//    }
//
//    public String getError() {
//        return errorMessage;
//    }
//
//    public List<Poses> getPoses() {
//        return poses;
//    }
//}

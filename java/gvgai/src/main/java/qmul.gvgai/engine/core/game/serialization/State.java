// automatically generated by the FlatBuffers compiler, do not modify

package qmul.gvgai.engine.core.game.serialization;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class State extends Table {
  public static State getRootAsState(ByteBuffer _bb) { return getRootAsState(_bb, new State()); }
  public static State getRootAsState(ByteBuffer _bb, State obj) { Constants.FLATBUFFERS_1_11_1(); _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { bb_pos = _i; bb = _bb; vtable_start = bb_pos - bb.getInt(bb_pos); vtable_size = bb.getShort(vtable_start); }
  public State __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public byte imageArray(int j) { int o = __offset(4); return o != 0 ? bb.get(__vector(o) + j * 1) : 0; }
  public int imageArrayLength() { int o = __offset(4); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer imageArrayAsByteBuffer() { return __vector_as_bytebuffer(4, 1); }
  public ByteBuffer imageArrayInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 4, 1); }
  public boolean isValidation() { int o = __offset(6); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public double gameScore() { int o = __offset(8); return o != 0 ? bb.getDouble(o + bb_pos) : 0.0; }
  public int gameTick() { int o = __offset(10); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int gameWinner() { int o = __offset(12); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public boolean isGameOver() { int o = __offset(14); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public double worldDimension(int j) { int o = __offset(16); return o != 0 ? bb.getDouble(__vector(o) + j * 8) : 0; }
  public int worldDimensionLength() { int o = __offset(16); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer worldDimensionAsByteBuffer() { return __vector_as_bytebuffer(16, 8); }
  public ByteBuffer worldDimensionInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 16, 8); }
  public int blockSize() { int o = __offset(18); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int noOfPlayers() { int o = __offset(20); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public double avatarSpeed() { int o = __offset(22); return o != 0 ? bb.getDouble(o + bb_pos) : 0.0; }
  public double avatarOrientation(int j) { int o = __offset(24); return o != 0 ? bb.getDouble(__vector(o) + j * 8) : 0; }
  public int avatarOrientationLength() { int o = __offset(24); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer avatarOrientationAsByteBuffer() { return __vector_as_bytebuffer(24, 8); }
  public ByteBuffer avatarOrientationInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 24, 8); }
  public double avatarPosition(int j) { int o = __offset(26); return o != 0 ? bb.getDouble(__vector(o) + j * 8) : 0; }
  public int avatarPositionLength() { int o = __offset(26); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer avatarPositionAsByteBuffer() { return __vector_as_bytebuffer(26, 8); }
  public ByteBuffer avatarPositionInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 26, 8); }
  public int avatarLastAction() { int o = __offset(28); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int avatarType() { int o = __offset(30); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int avatarHealthPoints() { int o = __offset(32); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int avatarMaxHealthPoints() { int o = __offset(34); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int avatarLimitHealthPoints() { int o = __offset(36); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public boolean isAvatarAlive() { int o = __offset(38); return o != 0 ? 0!=bb.get(o + bb_pos) : false; }
  public int availableActions(int j) { int o = __offset(40); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int availableActionsLength() { int o = __offset(40); return o != 0 ? __vector_len(o) : 0; }
  public ByteBuffer availableActionsAsByteBuffer() { return __vector_as_bytebuffer(40, 4); }
  public ByteBuffer availableActionsInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 40, 4); }
  public IntKeyValuePair avatarResources(int j) { return avatarResources(new IntKeyValuePair(), j); }
  public IntKeyValuePair avatarResources(IntKeyValuePair obj, int j) { int o = __offset(42); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int avatarResourcesLength() { int o = __offset(42); return o != 0 ? __vector_len(o) : 0; }
  public IntKeyValuePair avatarResourcesByKey(int key) { int o = __offset(42); return o != 0 ? IntKeyValuePair.__lookup_by_key(null, __vector(o), key, bb) : null; }
  public IntKeyValuePair avatarResourcesByKey(IntKeyValuePair obj, int key) { int o = __offset(42); return o != 0 ? IntKeyValuePair.__lookup_by_key(obj, __vector(o), key, bb) : null; }
  public Observation observationGrid(int j) { return observationGrid(new Observation(), j); }
  public Observation observationGrid(Observation obj, int j) { int o = __offset(44); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int observationGridLength() { int o = __offset(44); return o != 0 ? __vector_len(o) : 0; }
  public int observationGridNum() { int o = __offset(46); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int observationGridMaxRow() { int o = __offset(48); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int observationGridMaxCol() { int o = __offset(50); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public Observation NPCPositions(int j) { return NPCPositions(new Observation(), j); }
  public Observation NPCPositions(Observation obj, int j) { int o = __offset(52); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int NPCPositionsLength() { int o = __offset(52); return o != 0 ? __vector_len(o) : 0; }
  public int NPCPositionsNum() { int o = __offset(54); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int NPCPositionsMaxRow() { int o = __offset(56); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public Observation immovablePositions(int j) { return immovablePositions(new Observation(), j); }
  public Observation immovablePositions(Observation obj, int j) { int o = __offset(58); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int immovablePositionsLength() { int o = __offset(58); return o != 0 ? __vector_len(o) : 0; }
  public int immovablePositionsNum() { int o = __offset(60); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int immovablePositionsMaxRow() { int o = __offset(62); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public Observation movablePositions(int j) { return movablePositions(new Observation(), j); }
  public Observation movablePositions(Observation obj, int j) { int o = __offset(64); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int movablePositionsLength() { int o = __offset(64); return o != 0 ? __vector_len(o) : 0; }
  public int movablePositionsNum() { int o = __offset(66); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int movablePositionsMaxRow() { int o = __offset(68); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public Observation resourcesPositions(int j) { return resourcesPositions(new Observation(), j); }
  public Observation resourcesPositions(Observation obj, int j) { int o = __offset(70); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int resourcesPositionsLength() { int o = __offset(70); return o != 0 ? __vector_len(o) : 0; }
  public int resourcesPositionsNum() { int o = __offset(72); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int resourcesPositionsMaxRow() { int o = __offset(74); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public Observation portalsPositions(int j) { return portalsPositions(new Observation(), j); }
  public Observation portalsPositions(Observation obj, int j) { int o = __offset(76); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int portalsPositionsLength() { int o = __offset(76); return o != 0 ? __vector_len(o) : 0; }
  public int portalsPositionsNum() { int o = __offset(78); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int portalsPositionsMaxRow() { int o = __offset(80); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public Observation fromAvatarSpritesPositions(int j) { return fromAvatarSpritesPositions(new Observation(), j); }
  public Observation fromAvatarSpritesPositions(Observation obj, int j) { int o = __offset(82); return o != 0 ? obj.__assign(__indirect(__vector(o) + j * 4), bb) : null; }
  public int fromAvatarSpritesPositionsLength() { int o = __offset(82); return o != 0 ? __vector_len(o) : 0; }
  public int fromAvatarSpritesPositionsNum() { int o = __offset(84); return o != 0 ? bb.getInt(o + bb_pos) : 0; }
  public int fromAvatarSpritesPositionsMaxRow() { int o = __offset(86); return o != 0 ? bb.getInt(o + bb_pos) : 0; }

  public static int createState(FlatBufferBuilder builder,
      int imageArrayOffset,
      boolean isValidation,
      double gameScore,
      int gameTick,
      int gameWinner,
      boolean isGameOver,
      int worldDimensionOffset,
      int blockSize,
      int noOfPlayers,
      double avatarSpeed,
      int avatarOrientationOffset,
      int avatarPositionOffset,
      int avatarLastAction,
      int avatarType,
      int avatarHealthPoints,
      int avatarMaxHealthPoints,
      int avatarLimitHealthPoints,
      boolean isAvatarAlive,
      int availableActionsOffset,
      int avatarResourcesOffset,
      int observationGridOffset,
      int observationGridNum,
      int observationGridMaxRow,
      int observationGridMaxCol,
      int NPCPositionsOffset,
      int NPCPositionsNum,
      int NPCPositionsMaxRow,
      int immovablePositionsOffset,
      int immovablePositionsNum,
      int immovablePositionsMaxRow,
      int movablePositionsOffset,
      int movablePositionsNum,
      int movablePositionsMaxRow,
      int resourcesPositionsOffset,
      int resourcesPositionsNum,
      int resourcesPositionsMaxRow,
      int portalsPositionsOffset,
      int portalsPositionsNum,
      int portalsPositionsMaxRow,
      int fromAvatarSpritesPositionsOffset,
      int fromAvatarSpritesPositionsNum,
      int fromAvatarSpritesPositionsMaxRow) {
    builder.startTable(42);
    State.addAvatarSpeed(builder, avatarSpeed);
    State.addGameScore(builder, gameScore);
    State.addFromAvatarSpritesPositionsMaxRow(builder, fromAvatarSpritesPositionsMaxRow);
    State.addFromAvatarSpritesPositionsNum(builder, fromAvatarSpritesPositionsNum);
    State.addFromAvatarSpritesPositions(builder, fromAvatarSpritesPositionsOffset);
    State.addPortalsPositionsMaxRow(builder, portalsPositionsMaxRow);
    State.addPortalsPositionsNum(builder, portalsPositionsNum);
    State.addPortalsPositions(builder, portalsPositionsOffset);
    State.addResourcesPositionsMaxRow(builder, resourcesPositionsMaxRow);
    State.addResourcesPositionsNum(builder, resourcesPositionsNum);
    State.addResourcesPositions(builder, resourcesPositionsOffset);
    State.addMovablePositionsMaxRow(builder, movablePositionsMaxRow);
    State.addMovablePositionsNum(builder, movablePositionsNum);
    State.addMovablePositions(builder, movablePositionsOffset);
    State.addImmovablePositionsMaxRow(builder, immovablePositionsMaxRow);
    State.addImmovablePositionsNum(builder, immovablePositionsNum);
    State.addImmovablePositions(builder, immovablePositionsOffset);
    State.addNPCPositionsMaxRow(builder, NPCPositionsMaxRow);
    State.addNPCPositionsNum(builder, NPCPositionsNum);
    State.addNPCPositions(builder, NPCPositionsOffset);
    State.addObservationGridMaxCol(builder, observationGridMaxCol);
    State.addObservationGridMaxRow(builder, observationGridMaxRow);
    State.addObservationGridNum(builder, observationGridNum);
    State.addObservationGrid(builder, observationGridOffset);
    State.addAvatarResources(builder, avatarResourcesOffset);
    State.addAvailableActions(builder, availableActionsOffset);
    State.addAvatarLimitHealthPoints(builder, avatarLimitHealthPoints);
    State.addAvatarMaxHealthPoints(builder, avatarMaxHealthPoints);
    State.addAvatarHealthPoints(builder, avatarHealthPoints);
    State.addAvatarType(builder, avatarType);
    State.addAvatarLastAction(builder, avatarLastAction);
    State.addAvatarPosition(builder, avatarPositionOffset);
    State.addAvatarOrientation(builder, avatarOrientationOffset);
    State.addNoOfPlayers(builder, noOfPlayers);
    State.addBlockSize(builder, blockSize);
    State.addWorldDimension(builder, worldDimensionOffset);
    State.addGameWinner(builder, gameWinner);
    State.addGameTick(builder, gameTick);
    State.addImageArray(builder, imageArrayOffset);
    State.addIsAvatarAlive(builder, isAvatarAlive);
    State.addIsGameOver(builder, isGameOver);
    State.addIsValidation(builder, isValidation);
    return State.endState(builder);
  }

  public static void startState(FlatBufferBuilder builder) { builder.startTable(42); }
  public static void addImageArray(FlatBufferBuilder builder, int imageArrayOffset) { builder.addOffset(0, imageArrayOffset, 0); }
  public static int createImageArrayVector(FlatBufferBuilder builder, byte[] data) { builder.startVector(1, data.length, 1); builder.createByteVector(data); return builder.endVector(); }
  public static void startImageArrayVector(FlatBufferBuilder builder, int numElems) { builder.startVector(1, numElems, 1); }
  public static void addIsValidation(FlatBufferBuilder builder, boolean isValidation) { builder.addBoolean(1, isValidation, false); }
  public static void addGameScore(FlatBufferBuilder builder, double gameScore) { builder.addDouble(2, gameScore, 0.0); }
  public static void addGameTick(FlatBufferBuilder builder, int gameTick) { builder.addInt(3, gameTick, 0); }
  public static void addGameWinner(FlatBufferBuilder builder, int gameWinner) { builder.addInt(4, gameWinner, 0); }
  public static void addIsGameOver(FlatBufferBuilder builder, boolean isGameOver) { builder.addBoolean(5, isGameOver, false); }
  public static void addWorldDimension(FlatBufferBuilder builder, int worldDimensionOffset) { builder.addOffset(6, worldDimensionOffset, 0); }
  public static int createWorldDimensionVector(FlatBufferBuilder builder, double[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addDouble(data[i]); return builder.endVector(); }
  public static void startWorldDimensionVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addBlockSize(FlatBufferBuilder builder, int blockSize) { builder.addInt(7, blockSize, 0); }
  public static void addNoOfPlayers(FlatBufferBuilder builder, int noOfPlayers) { builder.addInt(8, noOfPlayers, 0); }
  public static void addAvatarSpeed(FlatBufferBuilder builder, double avatarSpeed) { builder.addDouble(9, avatarSpeed, 0.0); }
  public static void addAvatarOrientation(FlatBufferBuilder builder, int avatarOrientationOffset) { builder.addOffset(10, avatarOrientationOffset, 0); }
  public static int createAvatarOrientationVector(FlatBufferBuilder builder, double[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addDouble(data[i]); return builder.endVector(); }
  public static void startAvatarOrientationVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addAvatarPosition(FlatBufferBuilder builder, int avatarPositionOffset) { builder.addOffset(11, avatarPositionOffset, 0); }
  public static int createAvatarPositionVector(FlatBufferBuilder builder, double[] data) { builder.startVector(8, data.length, 8); for (int i = data.length - 1; i >= 0; i--) builder.addDouble(data[i]); return builder.endVector(); }
  public static void startAvatarPositionVector(FlatBufferBuilder builder, int numElems) { builder.startVector(8, numElems, 8); }
  public static void addAvatarLastAction(FlatBufferBuilder builder, int avatarLastAction) { builder.addInt(12, avatarLastAction, 0); }
  public static void addAvatarType(FlatBufferBuilder builder, int avatarType) { builder.addInt(13, avatarType, 0); }
  public static void addAvatarHealthPoints(FlatBufferBuilder builder, int avatarHealthPoints) { builder.addInt(14, avatarHealthPoints, 0); }
  public static void addAvatarMaxHealthPoints(FlatBufferBuilder builder, int avatarMaxHealthPoints) { builder.addInt(15, avatarMaxHealthPoints, 0); }
  public static void addAvatarLimitHealthPoints(FlatBufferBuilder builder, int avatarLimitHealthPoints) { builder.addInt(16, avatarLimitHealthPoints, 0); }
  public static void addIsAvatarAlive(FlatBufferBuilder builder, boolean isAvatarAlive) { builder.addBoolean(17, isAvatarAlive, false); }
  public static void addAvailableActions(FlatBufferBuilder builder, int availableActionsOffset) { builder.addOffset(18, availableActionsOffset, 0); }
  public static int createAvailableActionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startAvailableActionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addAvatarResources(FlatBufferBuilder builder, int avatarResourcesOffset) { builder.addOffset(19, avatarResourcesOffset, 0); }
  public static int createAvatarResourcesVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startAvatarResourcesVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addObservationGrid(FlatBufferBuilder builder, int observationGridOffset) { builder.addOffset(20, observationGridOffset, 0); }
  public static int createObservationGridVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startObservationGridVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addObservationGridNum(FlatBufferBuilder builder, int observationGridNum) { builder.addInt(21, observationGridNum, 0); }
  public static void addObservationGridMaxRow(FlatBufferBuilder builder, int observationGridMaxRow) { builder.addInt(22, observationGridMaxRow, 0); }
  public static void addObservationGridMaxCol(FlatBufferBuilder builder, int observationGridMaxCol) { builder.addInt(23, observationGridMaxCol, 0); }
  public static void addNPCPositions(FlatBufferBuilder builder, int NPCPositionsOffset) { builder.addOffset(24, NPCPositionsOffset, 0); }
  public static int createNPCPositionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startNPCPositionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addNPCPositionsNum(FlatBufferBuilder builder, int NPCPositionsNum) { builder.addInt(25, NPCPositionsNum, 0); }
  public static void addNPCPositionsMaxRow(FlatBufferBuilder builder, int NPCPositionsMaxRow) { builder.addInt(26, NPCPositionsMaxRow, 0); }
  public static void addImmovablePositions(FlatBufferBuilder builder, int immovablePositionsOffset) { builder.addOffset(27, immovablePositionsOffset, 0); }
  public static int createImmovablePositionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startImmovablePositionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addImmovablePositionsNum(FlatBufferBuilder builder, int immovablePositionsNum) { builder.addInt(28, immovablePositionsNum, 0); }
  public static void addImmovablePositionsMaxRow(FlatBufferBuilder builder, int immovablePositionsMaxRow) { builder.addInt(29, immovablePositionsMaxRow, 0); }
  public static void addMovablePositions(FlatBufferBuilder builder, int movablePositionsOffset) { builder.addOffset(30, movablePositionsOffset, 0); }
  public static int createMovablePositionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startMovablePositionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addMovablePositionsNum(FlatBufferBuilder builder, int movablePositionsNum) { builder.addInt(31, movablePositionsNum, 0); }
  public static void addMovablePositionsMaxRow(FlatBufferBuilder builder, int movablePositionsMaxRow) { builder.addInt(32, movablePositionsMaxRow, 0); }
  public static void addResourcesPositions(FlatBufferBuilder builder, int resourcesPositionsOffset) { builder.addOffset(33, resourcesPositionsOffset, 0); }
  public static int createResourcesPositionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startResourcesPositionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addResourcesPositionsNum(FlatBufferBuilder builder, int resourcesPositionsNum) { builder.addInt(34, resourcesPositionsNum, 0); }
  public static void addResourcesPositionsMaxRow(FlatBufferBuilder builder, int resourcesPositionsMaxRow) { builder.addInt(35, resourcesPositionsMaxRow, 0); }
  public static void addPortalsPositions(FlatBufferBuilder builder, int portalsPositionsOffset) { builder.addOffset(36, portalsPositionsOffset, 0); }
  public static int createPortalsPositionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startPortalsPositionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addPortalsPositionsNum(FlatBufferBuilder builder, int portalsPositionsNum) { builder.addInt(37, portalsPositionsNum, 0); }
  public static void addPortalsPositionsMaxRow(FlatBufferBuilder builder, int portalsPositionsMaxRow) { builder.addInt(38, portalsPositionsMaxRow, 0); }
  public static void addFromAvatarSpritesPositions(FlatBufferBuilder builder, int fromAvatarSpritesPositionsOffset) { builder.addOffset(39, fromAvatarSpritesPositionsOffset, 0); }
  public static int createFromAvatarSpritesPositionsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addOffset(data[i]); return builder.endVector(); }
  public static void startFromAvatarSpritesPositionsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static void addFromAvatarSpritesPositionsNum(FlatBufferBuilder builder, int fromAvatarSpritesPositionsNum) { builder.addInt(40, fromAvatarSpritesPositionsNum, 0); }
  public static void addFromAvatarSpritesPositionsMaxRow(FlatBufferBuilder builder, int fromAvatarSpritesPositionsMaxRow) { builder.addInt(41, fromAvatarSpritesPositionsMaxRow, 0); }
  public static int endState(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }
}

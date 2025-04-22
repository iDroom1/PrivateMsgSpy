# PrivateMsgSpy Plugin

**PrivateMsgSpy** is a lightweight Minecraft Spigot plugin that allows server staff to **spy on private messages** between players. It provides an easy-to-use command to toggle the spy mode and view private messages.

### ✨ Features
- **Private message monitoring**: Staff can read private messages sent between players.
- **Simple command interface**: The `/msgspy` command allows staff to toggle spy mode on/off.
- **Compatible with Minecraft 1.21+**: Built for the latest Spigot API.
- **Lightweight & efficient**: No performance impact on your server.

---

## ⚙️ **Installation**

1. Download the latest release from [releases](https://github.com/iDroom1/PrivateMsgSpy/releases).
2. Place the `PrivateMsgSpy.jar` file into your server's `plugins` folder.
3. Restart your server to load the plugin.

---

## 📝 **Commands**

| Command      | Description                                  | Permission              |
|--------------|----------------------------------------------|-------------------------|
| `/msgspy`    | Toggle spy mode for private messages         | `privatemsgspy.spy`      |

### Command Usage:
- `/msgspy` - Toggles the state of private message spying.
  - When enabled, all private messages sent between players will be logged to the staff member’s console.

---

## 🔒 **Permissions**

| Permission              | Description                                               |
|-------------------------|-----------------------------------------------------------|
| `privatemsgspy.spy`      | Grants permission to use the `/msgspy` command to toggle spy mode |

---

## 💻 **Plugin Configuration**

**PrivateMsgSpy** does not require any configuration by default. However, if you'd like to customize the behavior or set up additional permissions, you can use the default permissions provided by the plugin.

---

## 📦 **Plugin.yml Example**

Make sure to include a `plugin.yml` in the `src/main/resources/` folder of your project:

```yaml
name: PrivateMsgSpy
version: 1.0
main: org.idroom.privatemsgspy.PrivateMsgSpy
api-version: 1.21
commands:
  msgspy:
    description: Toggle message spy mode.
    usage: /msgspy
permissions:
  privatemsgspy.spy:
    description: Allows using the /msgspy command.
    default: op

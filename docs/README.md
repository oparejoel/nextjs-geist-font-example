## Documentation

This repository contains a Next.js frontend with a set of reusable UI components and a separate JavaFX application for car registration.

- **Frontend UI Components**: see `UI_COMPONENTS.md`
- **Frontend Hooks & Utilities**: see `HOOKS_UTILS.md`
- **Java Application APIs**: see `JAVA_APP.md`

### Conventions
- **Path alias**: Frontend imports use the `@/*` alias which points to `src/*`.
  - Example: `import { Button } from '@/components/ui/button'`
- **Styling**: Components are Tailwind CSS-based and built on top of Radix UI primitives where applicable.

### Contents
- `UI_COMPONENTS.md`: All exported UI components with examples
- `HOOKS_UTILS.md`: Utility functions and React hooks with examples
- `JAVA_APP.md`: Java domain model, DAO, controllers, and database utilities with usage examples